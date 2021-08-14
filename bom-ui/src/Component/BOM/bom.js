import React, { Component } from 'react'
import Navbar from './Navbar'
export default class Bom extends Component {
    render() {
        return (
            <div>
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
