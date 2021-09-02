import React from 'react'

const Favourite = ({ car }) => {
    return (
        <div className='fav' data-testid="test-3">
            <p>{car.year_model} {car.make} {car.model} <i style={{float: 'right'}}>{car.price} €</i></p>
        </div>
    )
}

export default Favourite
