/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { Component } from 'react';
import Navbar from './Navbar';
import axios from 'axios';

export default class Bom extends Component {
    state = {
        tabs: []
    }
    componentDidMount = () => {
        axios({
            method: 'get',
            url: 'http://localhost:8081/bom-api/boms/all/enviornments',
            headers: {
                'Content-Type': 'application/json'
            }
        })

            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });

    }
    render() {
        return (
            <div>
                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Active</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
                <Navbar />
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
                        <tr>
                            <th scope="row">1</th>
                            <td>account-security-service</td>
                            <td>1.10.9</td>
                            <td>bdab434k34kbkbh3kb4hb1</td>
                            <td>Rajat Jain</td>
                            <td>https://bom.jira.net/1123</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>registration-service</td>
                            <td>1.10.10</td>
                            <td>bdab4dkscbkjdnckjnk</td>
                            <td>Shubham Jain</td>
                            <td>https://bom.jira.net/1125</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}
