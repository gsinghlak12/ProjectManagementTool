import React, { Component } from 'react';

class AddProject extends Component {
    constructor() {
        super()

        this.state = {
            "projectName": "",
            "projectIdentifier": "",
            "description": "",
            "start_date": "",
            "end_date": ""
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit = (e) => {
        e.preventDefault();
        const newProject = {
            "projectName": this.state.projectName,
            "projectIdentifier": this.state.projectIdentifier,
            "description": this.state.description,
            "start_date": this.state.start_date,
            "end_date": this.state.end_date
        };
    }

    render() {
        return (
            <div className="register">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Create Project form</h5>
                            <hr />
                            <form onSubmit={(e) => this.onSubmit(e)}>
                                <div className="form-group">
                                    <input type="text"
                                        className="form-control form-control-lg "
                                        placeholder="Project Name"
                                        name='projectName'
                                        value={this.state.projectName}
                                        onChange={(e) => this.onChange(e)}
                                    />
                                </div>
                                <br />
                                <div className="form-group">
                                    <input type="text"
                                        className="form-control form-control-lg"
                                        placeholder="Unique Project ID"
                                        name='projectIdentifier'
                                        value={this.state.projectIdentifier}
                                        onChange={(e) => this.onChange(e)}
                                    />
                                </div>
                                <br />
                                <div className="form-group">
                                    <textarea
                                        className="form-control form-control-lg"
                                        placeholder="Project Description"
                                        name="description"
                                        value={this.state.description}
                                        onChange={(e) => this.onChange(e)}
                                    />

                                </div>
                                <br />
                                <h6>Start Date</h6>
                                <div className="form-group">
                                    <input
                                        type="date"
                                        className="form-control form-control-lg"
                                        name="start_date"
                                        value={this.state.start_date}
                                        onChange={(e) => this.onChange(e)} />

                                </div>
                                <br />
                                <h6>Estimated End Date</h6>
                                <div className="form-group">
                                    <input
                                        type="date"
                                        className="form-control form-control-lg"
                                        name="end_date"
                                        value={this.state.end_date}
                                        onChange={(e) => this.onChange(e)} />

                                </div>
                                <input
                                    type="submit"
                                    className="btn btn-primary btn-block mt-4"
                                    name='submit' />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddProject