import React from 'react'
import { useState, useEffect } from 'react'
import DetailedCarView from './DetailedCarView'



const CarView = ({carToShow}) => {
    const [open, setOpen] = useState(false)
    const [detailedCar, setDetailedCar] = useState()

    const getOneCarInfo = async (id) => {
        const res = await fetch(`http://localhost:8081/api/v1/warehouse/vehicle/${id}`)
        const data = await res.json();
        setDetailedCar(data)
        setOpen(!open)
        return data
    }

    return (
        <div className='car'>
            <h2>{carToShow.year_model} {carToShow.make} {carToShow.model}</h2> <span style={{float: 'right'}}>(added: {carToShow.date_added})</span>
            <p>Price: € {carToShow.price}</p>
            {
                carToShow.licensed ? '' : <p style={{backgroundColor:'lightcoral', padding:'5px'}}>Not licensed</p>
            }
            {
                carToShow.licensed &&
                    <button
                    onClick={() => getOneCarInfo(carToShow._id)}
                    type='button'
                    className='btn btn-primary'
                    >
                    See more
                    </button>    
            }
            {
                (open) &&
                    <div>
                        <DetailedCarView car={detailedCar} />
                    </div>
            }
            
        </div>
    )
}

export default CarView
