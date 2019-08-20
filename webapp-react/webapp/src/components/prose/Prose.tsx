import React, { Component } from 'react'

interface IProps{
    proseBody: string; 
}

interface IState{

}

export default class Prose extends Component<IProps, IState> {
    inlineStyle = {
        fontSize: "18px"
    };
    
    render() {
        return (
            // <div  className="container-fluid">
              <div className="row">
                  <div className="col-12-sm">
                    <div style={this.inlineStyle}>
                        <span>1.</span>
                        {this.props.proseBody}
                    </div>
                  </div>
              </div>
        );
    }
}
