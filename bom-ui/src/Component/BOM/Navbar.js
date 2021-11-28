/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { Component } from 'react'
import Select from 'react-select'
import axios from 'axios';

export default class Navbar extends Component {
//    state = {
//        options: [
//            { value: 'development', label: 'development' },
//            { value: 'staging', label: 'staging' },
//            { value: 'preproduction', label: 'preproduction' },
//            { value: 'production', label: 'production' }
//        ]
//    }
    state = {
            options: []
    }
    componentDidMount = () => {
            axios({
                method: 'get',
                url: 'http://localhost:8081/bom-api/boms/all/environments',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then((response)=> {
                    var data = response.data;
                    this.setState({
                        options: data.map(el=>[{value:el,label:el}][0]),
                        default: {value:data[0],label:data[0]},
                        env: data[0]
                    },
                    () => {
                        this.getData()
                        }
                    )
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    selectEnv = (e) => {
        this.setState({
            env: e.value,
            default: e
        },
        () => {
          this.getData()
        })
     }

    getData = () => {
                axios({
                                method: 'get',
                                url: `http://localhost:8081/bom-api/boms/${this.state.env}/all`,
                                headers: {
                                    'Content-Type': 'application/json'
                                }
                            })
                                .then((response)=> {
                                    var data = response.data;
                                    //console.log(data);
                                    this.setState({
                                        envData: data
                                    })
                                    this.props.getEnvData(this.state.envData);
                                })
                                .catch(function (error) {
                                    console.log(error);
                                });
                }


    render() {
        return (
            <div>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid d-flex justify-content-between">
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li style={{width:'250px'}}>
                                    <Select onChange={this.selectEnv}
                                        className="basic-single"
                                        classNamePrefix="select"
                                        value={this.state.default}
                                        isSearchable={true}
                                        name="color"
                                        options={this.state.options}
                                    />
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        )
    }
}
