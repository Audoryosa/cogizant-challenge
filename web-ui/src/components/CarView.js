import React from 'react'


const CarView = ({carToShow}) => {
    
    return (
        <div className='car'>
            <h2>{carToShow.year_model} {carToShow.make} {carToShow.model}</h2> <span style={{float: 'right'}}>(added: {carToShow.date_added})</span>
            <p>Price: € {carToShow.price}</p>
        </div>
    )
}

export default CarView
