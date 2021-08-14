import React, { Component } from 'react';
import Bom from './Component/BOM/bom'
class App extends Component {

    state = {};

    componentDidMount() {
        // this.dadJokes()
    }

    // dadJokes = () => {
    //     fetch('/bom-api/boms/health')
    //         .then(response => response.text())
    //         .then(message => {
    //             this.setState({ message: message });
    //         });
    // };

    render() {
        return (
            <div>
                <Bom />
            </div>
        );
    }
}

export default App;