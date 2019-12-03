import * as React from 'react';
import { Component } from 'react';
import httpService from '../../services/http/HttpService';
import { Constants } from '../../utilities/Constants';

interface ISection {
  sectionName: string;
}
interface IState {
  sectionsList: ISection[]
}

export default class Navbar extends Component<any, IState> {
  state = {
    sectionsList: [
      {sectionName: "Quants"},
      {sectionName: "LR"},
      {sectionName: "Verbal"}
    ]
  }

  private getSections = () => {
    return this.state.sectionsList.map(section => (
      <a className="dropdown-item" href={"/sections/"+section.sectionName}>{section.sectionName}</a>
    ));
  };

  async componentDidMount() {
    let resp = await httpService.get(Constants.HOST_NAME + Constants.GET_SECTIONS);
    this.setState({sectionsList: resp});
  }

  public render() {
    return (
      <div className="Navbar">
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
          <a id="navbarBrandName" className="navbar-brand" href="/">ContentCrack</a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
  
          <div className="collapse navbar-collapse" id="navbarColor01">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <a className="nav-link" href="/">Home</a>
              </li>
              <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Sections
                </a>
                <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                    {this.getSections()}
                </div>
              </li>
              <li className="nav-item">
                <a className="nav-link disabled" href="#">Articles</a>
              </li>
              <li className="nav-item">
                <a className="nav-link disabled" href="#">Tests</a>
              </li>
  
            </ul>
          </div>
        </nav>
        </div>
      );
  }
}