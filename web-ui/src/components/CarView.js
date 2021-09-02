import React from 'react'
import { useState, useEffect } from 'react'
import DetailedCarView from './DetailedCarView'
import { AiOutlineStop } from 'react-icons/ai'



const CarView = ({carToShow}) => {
    const [open, setOpen] = useState(false)
    const [detailedCar, setDetailedCar] = useState()

    const getOneCarInfo = async (id) => {
        const res = await fetch(`http://localhost:8081/api/v1/warehouse/${id}`)
        const data = await res.json();
        setDetailedCar(data)
        setOpen(!open)
        return data
    }

    return (
        <div className='car' data-testid='test-1'>
            <div>
                <h2>{carToShow.year_model} {carToShow.make} {carToShow.model}</h2> 
                <span>(added: {carToShow.date_added})</span>
            </div>
            
            <p>Price: {carToShow.price} €</p>
            {
                carToShow.licensed ? '' : <p style={{backgroundColor:'lightcoral', padding:'5px'}}><AiOutlineStop /> Not licensed </p>
            
            }
            {
                carToShow.licensed &&
                    <button
                    onClick={() => getOneCarInfo(carToShow._id)}
                    type='button'
                    className='btn btn-primary'
                    >
                    {open ? 'See less' : 'See more'}
                    </button>    
            }
            {
                (open) &&
                    <div>
                        <DetailedCarView warehouse={detailedCar} />
                    </div>
            }
            
        </div>
    )
}

export default CarView
