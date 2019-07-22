import React, { Component } from 'react'
import { IQuestion } from '../../utilities/Types';

interface IState {
    
}

interface IProps {
    question: IQuestion;
}

export default class Question extends Component<IProps, IState> {
    render() {
        return (
            <div className="card">
                <div className="card-body">
                    <div className="card-title">
                        {this.props.question.statement}
                    </div>
                </div>
            </div>
        )
    }
}
