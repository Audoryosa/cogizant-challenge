import React from 'react';

import axios from 'axios';

export default class PersonList extends React.Component {
    state = {
        cars: []
    }

    componentDidMount() {
        axios.get(`http://localhost:8081/api/v1/warehouse/vehicle`)
            .then(res => {
                const cars = res.data;
                this.setState({ cars });
            })
    }

    render() {
        return (
            <ul>
                { this.state.cars.map(car => <li>{car.make} {car.model}</li>)}
            </ul>
        )
    }
}