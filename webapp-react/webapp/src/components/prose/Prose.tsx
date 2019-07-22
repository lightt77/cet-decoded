import React, { Component } from 'react'

interface IProps{
    proseBody: string; 
}

interface IState{

}

export default class Prose extends Component<IProps, IState> {
    render() {
        return (
            <div>
                <div className="jumbotron">
                    {this.props.proseBody}
                </div>
            </div>
        )
    }
}
