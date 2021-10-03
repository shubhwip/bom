import React, { Component } from 'react';
import Bom from './Component/BOM/bom'
import Register from './Component/Register/register'
import {Switch, Route} from 'react-router-dom'
class App extends Component {

    state = {};

    componentDidMount() {
        // this.dadJokes()
    }

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path = "/">
                        <Bom />
                    </Route>
                    <Route exact path = "/register">
                        <Register />
                     </Route>
                </Switch>
            </div>
        );
    }
}

export default App;