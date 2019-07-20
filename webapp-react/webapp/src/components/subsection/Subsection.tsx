import React, { Component } from "react";
import HttpService from "../../services/http/HttpService";
import { Constants } from "../../utilities/Constants";

interface ISubsectionState{
  exerciseCount: number;
}

interface ISubsectionProps{
  match: any;
}

export default class Subsection extends Component<ISubsectionProps, ISubsectionState> {
  state = {
    exerciseCount: 0
  };

  async componentDidMount(){
    let resp = await HttpService.get((Constants.HOST_NAME + Constants.GET_EXERCISES_LIST_URL)
                                        .replace("{subsectionName}", this.props.match.params.subSectionName));
    console.log(resp);
    this.setState({exerciseCount: resp});
  }

  private getExerciseList() {
    let exerciseList = [];
    for (let i = 1; i <= this.state.exerciseCount; i++) {
      exerciseList.push((<a className="list-group-item list-group-item-action" 
          href={"/sections/" + this.props.match.params.sectionName + "/subsections/" + this.props.match.params.subSectionName + "/exercises/" + i}>{"Exercise "+ i}</a>))
    }
    return exerciseList;
  }

  render() {
    return (
      <div className="Subsection">
        Section : {this.props.match.params.sectionName}
        <br />
        Subsection : {this.props.match.params.subSectionName}
        <ul className="list-group">
          {this.getExerciseList()}
        </ul>
      </div>
    );
  }
}