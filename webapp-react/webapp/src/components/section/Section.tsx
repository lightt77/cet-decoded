import React, { Component } from 'react';
import HttpService from '../../services/http/HttpService';
import { Constants } from '../../utilities/Constants';

interface ISubsection {
  subsectionName: string;
}

interface ISectionState{
  subSectionsList: ISubsection[];
}

interface ISectionProp{
  match: any;
}

export default class Section extends Component<ISectionProp, ISectionState> {
  state = {
    subSectionsList: [
      {subsectionName: ""}
    ]
  };

  async componentDidMount() {
    let resp = await HttpService.get((Constants.HOST_NAME + Constants.GET_SUBSECTIONS_LIST_URL)
                                        .replace("{sectionName}", this.props.match.params.sectionName));
    this.setState({subSectionsList: resp});
  }
  
  getSubSections = () => {
    return this.state.subSectionsList.map(x => (<a className="list-group-item list-group-item-action" href={"/sections/"+this.props.match.params.sectionName+"/subsections/"+x.subsectionName}>{x.subsectionName}</a>));
  };

  render() {
    return (
      <div className="Section">
        Section : {this.props.match.params.sectionName}
        <ul className="list-group">
          {this.getSubSections()}
        </ul>
      </div>
    )
  }
}


