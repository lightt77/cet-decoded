import * as React from 'react';
import { Component } from 'react';
import httpService from '../../services/http/HttpService';
import { Constants } from '../../utilities/Constants';

export default class Navbar extends Component {
  state = {
    sectionsList: []
  }

  private getSections = () => {
    // console.log("Abhishek");
    // console.log(this.state.sectionsList);
    // return this.state.sectionsList.map(section => (
    //   <a className="dropdown-item" href="#">{section}</a>
    // ));
    console.log("state is ");
    console.log(this.state.sectionsList);
  };

  async componentDidMount() {
    console.log("componentWillMount");
    httpService.get(Constants.hostName + Constants.getSectionsUrl)
      .then(x=>console.log(JSON.stringify(x.json())));
    // console.log(response);
    // this.setState({
    //   sectionsList: response.json()
    // })
  }

  public render() {
    return (
      <div className="Navbar">
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a id="navbarBrandName" className="navbar-brand" href="#">CetDecoded</a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
  
          <div className="collapse navbar-collapse" id="navbarColor03">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <a className="nav-link" href="#">Home</a>
              </li>
              <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Sections
                </a>
                <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                  {/* {this.getSections()} */}
                </div>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">Articles</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">Tests</a>
              </li>
              
            </ul>
          </div>
        </nav>
      </div>
    );  
  }
}