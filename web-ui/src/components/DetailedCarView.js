import React from 'react'
import { useState, useEffect } from 'react'
import _ from 'lodash'

const DetailedCarView = ({ car }) => {
    const [favs, setFavs] = useState([])

    useEffect(() => {
        const currentFavourites = JSON.parse(localStorage.getItem('favs')) || []
        setFavs(currentFavourites)
    }, [])

    const handleAddFavourite = (id) => {
        if (!favs.includes(id)) {
            var currentFavourites = JSON.parse(localStorage.getItem('favs')) || []
            currentFavourites.push(id)
            setFavs(currentFavourites)
            localStorage.setItem('favs', JSON.stringify(currentFavourites))
        } else {
            alert("This car is already marked as favourite!")
        }
    }

    const handleRemoveFavourite = (id) => {
        var currentFavourites = JSON.parse(localStorage.getItem('favs'))
        currentFavourites = _.filter(currentFavourites, item => item !== id)
        setFavs(currentFavourites)
        localStorage.setItem('favs', JSON.stringify(currentFavourites))
    }

    return (
        <div>
            <h3>{car.make}, costs just {car.price}</h3>
            <button className='btn' onClick={() => handleAddFavourite(car._id)} style={{backgroundColor: 'green'}}>
                Add to favourites
            </button>
            {
                favs.includes(car._id) &&
                <button className='btn' onClick={() => handleRemoveFavourite(car._id)} style={{backgroundColor: 'coral'}}>
                Remove from favourties
            </button>
            }
        </div>
    )
}

export default DetailedCarView
