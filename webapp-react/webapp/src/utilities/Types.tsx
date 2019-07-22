export interface IQuestion {
    answer: string,
    expectedTimeToAnswer: number,
    options: string,
    proseId: number,
    solution: string,
    statement: string,
    type: number
}

export interface IProseQuestionSet {
    prose: IProse,
    questionsList: IQuestion[]
}

export interface IProse {
    proseBody: string
}