import React from 'react'
import { useState } from 'react'
import CarView from './CarView'

const CarsContainer = ({ cars }) => {

    return (
        <>
          {cars.map((car) => (
              <CarView key={car._id} carToShow={car} />
        ))}  
        </>
    )
}

export default CarsContainer
