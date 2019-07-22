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
    console.log(resp);
    this.setState({exerciseInfo: resp});
  }

  private getProseQuestions = () => {
    return this.state.exerciseInfo.proseQuestionSets.map(proseQuestionSet => {
      return (
        <div>
          <Prose proseBody={(proseQuestionSet as any).prose.proseBody}></Prose>
          <div>{this.getQuestions((proseQuestionSet as any).questionsList)}</div>
        </div>
      );
    });
  };

  private getQuestions = (questions: IQuestion[]) => {
    return questions.map(question => {
      return (<Question question={question}></Question>);
    })
  };

  render() {
    return (
      <div>
        {this.getProseQuestions()}
        {this.getQuestions(this.state.exerciseInfo.individualQuestions)}
      </div>
    );
  }
}
