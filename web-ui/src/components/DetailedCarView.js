import React from 'react'

const DetailedCarView = ({ car }) => {

    return (
        <div>
            <h3>{car.make}, costs just {car.price}</h3>
        </div>
    )
}

export default DetailedCarView
