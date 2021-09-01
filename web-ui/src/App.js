import { useState, useEffect } from 'react'
import Header from './components/Header'
import CarsContainer from './components/CarsContainer'
import Favourites from './components/Favourites'

const App = () => {
    const [cars, setCars] = useState([])
    const [showFavourites, setShowFavourites] = useState()

    useEffect(() => {
        const getCars = async () => {
            const carsFromServer = await fetchCars()
            setCars(carsFromServer)
        }
        getCars()
    }, [])

    const fetchCars = async () => {
        const res = await fetch(`http://localhost:8081/api/v1/warehouse/vehicle?sort=asc`)
        const data = await res.json()

        return data
    }

    return (
        <div className='container'>
            <Header />
            <button style={{backgroundColor: 'green'}} className='btn' onClick={() => setShowFavourites(!showFavourites)}>
                {showFavourites ? 'Close' : 'Show favourites'}
            </button>
            {
                (showFavourites) &&
                    <Favourites cars={cars} />
            }
            {
                cars.length > 0 ? <CarsContainer cars={cars}/> : <h2>No vehicles at the time.</h2>    
            }
            
        </div>
    )
}

export default App