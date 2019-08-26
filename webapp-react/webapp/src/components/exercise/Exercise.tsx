import React, { Component } from 'react';
import HttpService from '../../services/http/HttpService';
import { Constants } from '../../utilities/Constants';
import { IProseQuestionSet, IQuestion } from '../../utilities/Types';
import Prose from '../prose/Prose';
import Question from '../question/Question';

interface IStateType{
    exerciseInfo: {
      proseQuestionSets: IProseQuestionSet[],
      individualQuestions: IQuestion[] 
    };
}

interface IPropType{
    match: any;
}

export default class Exercise extends Component<IPropType, IStateType> {
  state = {
    exerciseInfo: {
      proseQuestionSets: [],
      individualQuestions: []
    }
  };

  async componentDidMount() {
    let resp = await HttpService.get(Constants.HOST_NAME + Constants.GET_EXERCISE_INFO
                                        .replace("{subsectionName}", this.props.match.params.subSectionName)
                                        .replace("{exerciseNumber}", this.props.match.params.exerciseNumber));
    this.setState({exerciseInfo: resp});
  }

  private getProseQuestions = () => {
    return this.state.exerciseInfo.proseQuestionSets.map((proseQuestionSet,index) => {
      return (
        <div>
          <Prose proseBody={(proseQuestionSet as any).prose.proseBody} id={index+1}></Prose>
          <div>{this.getQuestions((proseQuestionSet as any).questionsList)}</div>
        </div>
      );
    });
  };

  private getQuestions = (questions: IQuestion[]) => {
    return questions.map((question, index) => {
      return (<Question question={question} id={index+1}></Question>);
    })
  };

  render() {
    return (
      <div className="container" style={{marginTop: "1rem"}}>
        {this.getProseQuestions()}
        <br/>
        {this.getQuestions(this.state.exerciseInfo.individualQuestions)}
      </div>
    );
  }
}
