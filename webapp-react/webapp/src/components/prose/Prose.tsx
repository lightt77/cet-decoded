import React, { Component } from 'react'

interface IProps{
    proseBody: string;
    id: number;
}

interface IState{

}

export default class Prose extends Component<IProps, IState> {
    inlineStyle = {
        fontSize: "18px"
    };

    private getProseBody = (rawProseBody: string) => {
        
    };
    
    render() {
        return (
            // <div  className="container-fluid">
              <div className="row">
                  <div className="col-12-sm">
                    <div style={this.inlineStyle}>
                        <span>{this.props.id}.&nbsp;&nbsp;</span>
                        {this.props.proseBody}
                    </div>
                  </div>
              </div>
        );
    }
}
