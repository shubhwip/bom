/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { Component } from 'react'
import Select from 'react-select'
export default class Navbar extends Component {
    state = {
        options: [
            { value: 'development', label: 'development' },
            { value: 'staging', label: 'staging' },
            { value: 'preproduction', label: 'preproduction' },
            { value: 'production', label: 'production' }
        ]
    }
    render() {
        return (
            <div>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                                <li style={{width:'250px'}}>
                                    <Select
                                        className="basic-single"
                                        classNamePrefix="select"
                                        isClearable={true}

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
