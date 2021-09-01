import React from 'react'
import { useState, useEffect } from 'react'
import _ from 'lodash'
import Favourite from './Favourite'

const Favourites = ({ cars }) => {
    const [favs, setFavs] = useState([])

    useEffect(() => {
        const currentFavourites = JSON.parse(localStorage.getItem('favs')) || []
        const favCars = _.filter(cars, car => currentFavourites.includes(car._id))
        setFavs(favCars)
    }, [])

    const totalPrice = () => {
        var sum = 0
        _.forEach(favs, car => {
            sum = sum + car.price
        })

        return sum.toFixed(2)
    }

    return (
        <div className='fav-container'>
            <p>This is a list of your liked cars:</p>
                {favs.map((fav) => <Favourite car={fav} />)} 
            <h3 style={{float: 'right'}}>Total: {totalPrice()} €</h3>
        </div>
    )
}

export default Favourites
