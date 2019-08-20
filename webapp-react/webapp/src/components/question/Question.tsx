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
        return question.options.split("//").map(option => {
            return (
                <li className="list-group-item" style={{border: "none"}}>{option}</li>
            );
        });
    };

    render() {
        return (
            <div className="card" style={{border: 'none'}}>
                <div className="card-body">
                    <div style={{marginRight: "1em", display: "inline-block"}}>1.</div>
                    
                    <span className="card-title">{this.props.question.statement}</span>
                    <ul className="list-group">
                        {this.getOptions(this.props.question)}
                        <button className="btn btn-info col-2" data-toggle="collapse" data-target={"#id"+this.props.id.toString()}>Show Solution</button>
                    </ul>
                    <div className="collapse" id={"id"+this.props.id.toString()}>
                        <p>
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                        </p>
                    </div>
                    
                </div>
            </div>
        )
    }
}
