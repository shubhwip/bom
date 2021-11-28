/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { Component } from 'react';
import Navbar from './Navbar';
import axios from 'axios';

export default class Bom extends Component {
    state = {envData : []}
    getEnvData = (data) => {
    this.setState({
        envData: data
        })
    }
    render() {
        const {envData} = this.state;
        return (
            <div>
                <Navbar
                getEnvData = {this.getEnvData}
                //name = "Shubham Jain"
                />

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">Service Name</th>
                            <th scope="col">Service Version</th>
                            <th scope="col">Version Control Checkout Hash</th>
                            <th scope="col">Commit Author</th>
                            <th scope="col">Release Ticket</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                                    envData !== undefined && envData.map((el,i)=>{
                                        return (
                                                                <tr>
                                                                    <th scope="row">{i+1}</th>
                                                                    <td>{el.serviceName}</td>
                                                                    <td>{el.serviceVersion}</td>
                                                                    <td>{el.versionControlCheckoutHash}</td>
                                                                    <td>{el.commitAuthor}</td>
                                                                    <td>https://bom.jira.net/1123</td>
                                                                </tr>
                                        )
                                    })
                        }

                    </tbody>
                </table>
            </div>
        )
    }
}
