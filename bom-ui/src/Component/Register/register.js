import React, { Component } from 'react';
import './register.css';
import axios from 'axios';
export default class Register extends Component {
    state = {
        name: ''
    }

    changeData = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }
    submitData = () => {
        var obj = {
            companyName: this.state.cname,
            email: this.state.email,
            maintainer: this.state.maintainer,
            versionControlUrl: this.state.version
        }
        axios.post('http:localhost:8081/customer/create', obj)
            .then((data) => {
                this.props.history.push('/')
            })

    }
    render() {
        return (
            <div className='container'>
                <div className='row'>
                    <div className='col-md-6 offset-3 mt-4'>
                        <div className='register-container'>
                            <form>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Company Name</label>
                                    <input type="text" class="form-control mt-1" name='cname' aria-describedby="emailHelp" placeholder="Enter Company Name" onChange={(e) => this.changeData(e)} />
                                </div>
                                <div class="form-group mt-2">
                                    <label for="exampleInputEmail1">Company Email</label>
                                    <input type="email" class="form-control mt-1" aria-describedby="emailHelp" name='email' placeholder="Enter Company Email" onChange={(e) => this.changeData(e)} />
                                </div>
                                <div class="form-group mt-2">
                                    <label for="exampleInputEmail1">Maintainer</label>
                                    <input type="text" class="form-control mt-1" aria-describedby="emailHelp" name='maintainer' placeholder="Enter Maintainer Name" onChange={(e) => this.changeData(e)} />
                                </div>
                                <div class="form-group mt-2">
                                    <label for="exampleInputEmail1">Version Control URL</label>
                                    <input type="text" class="form-control mt-1" aria-describedby="emailHelp" name='version' placeholder="Enter Version Control URL" onChange={(e) => this.changeData(e)} />
                                </div>
                                <button type="submit" class="btn btn-primary mt-3" onClick={() => this.submitData()}>Submit</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        )
    }
}
