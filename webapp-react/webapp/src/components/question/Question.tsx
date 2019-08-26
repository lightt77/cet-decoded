import React, { Component } from 'react'
import { IQuestion } from '../../utilities/Types';

interface IState {
    
}

interface IProps {
    question: IQuestion;
    id: number;
}

export default class Question extends Component<IProps, IState> {
    private getOptions = (question: IQuestion) => {
        return question.options.split("//").map((option, index) => {
            return (
                <li className="list-group-item" style={{border: "none"}}>{String.fromCharCode(97+index)}.&nbsp;&nbsp;{option}</li>
            );
        });
    };

    render() {
        return (
            <div className="card" style={{border: 'none'}}>
                <div className="card-body">
                    <div style={{marginRight: "1em", display: "inline-block"}}>{this.props.id}.</div>
                    
                    <span className="card-title">{this.props.question.statement}</span>
                    <ul className="list-group">
                        {this.getOptions(this.props.question)}
                        <button className="btn btn-info col-2" data-toggle="collapse" data-target={"#id"+this.props.id.toString()}>Show Solution</button>
                    </ul>
                    <div className="collapse" id={"id"+this.props.id.toString()}>
                        <p>{this.props.question.solution}</p>
                    </div>
                    
                </div>
            </div>
        )
    }
}
