import React, { Component } from "react";
import HttpService from "../../services/http/HttpService";
import { Constants } from "../../utilities/Constants";

interface ISubsectionState{
  exerciseList: string[];
}

interface ISubsectionProps{
  match: any;
}

export default class Subsection extends Component<ISubsectionProps, ISubsectionState> {
  state = {
    exerciseList: []
  };

  async componentDidMount(){
    let resp = await HttpService.get((Constants.HOST_NAME + Constants.GET_EXERCISES_LIST)
                                        .replace("{subsectionName}", this.props.match.params.subSectionName));
    this.setState({exerciseList: resp});
  }

  private getExerciseList() {
    return this.state.exerciseList
            .map((exercise) => {
              return (
                <a className="list-group-item list-group-item-action"
                    href={"/sections/" + this.props.match.params.sectionName + "/subsections/" + this.props.match.params.subSectionName + "/exercises/" + exercise}>{exercise}</a>
              );
            });
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