import { render, screen, cleanup } from "@testing-library/react";
import CarView from "../CarView";
import DetailedCarView from "../DetailedCarView";
import Favourite from "../Favourite";

afterEach(() => {
    cleanup()
})

test('carView should render', () => {
    const car = {
              "make": "Chevrolet",
              "model": "Corvette",
              "year_model": 2004,
              "price": 20019.64,
              "licensed": true,
              "date_added": "2018-01-27"
            }

    render(<CarView carToShow={car} />)
    const testElement = screen.getByTestId('test-1')
    expect(testElement).toBeInTheDocument()
    expect(testElement).toHaveTextContent(car.make)
    expect(testElement).toHaveTextContent('Price: ' + car.price)
})

test('carView not licensed car should render and have not licensed text', () => {
    const car = {
              "make": "Chevrolet",
              "model": "Corvette",
              "year_model": 2004,
              "price": 20019.64,
              "licensed": false,
              "date_added": "2018-01-27"
            }

    render(<CarView carToShow={car} />)
    const testElement = screen.getByTestId('test-1')
    expect(testElement).toBeInTheDocument()
    expect(testElement).toHaveTextContent(car.make)
    expect(testElement).toHaveTextContent('Price: ' + car.price)
    expect(testElement).toHaveTextContent('Not licensed')
})

test('detailedCarView should render with correct warehouse name', () => {
    const warehouse = {
        "name": "Warehouse A",
        "location": {
          "lat": "47.13111",
          "long": "-61.54801"
        },
        "cars": {
          "location": "West wing",
          "vehicles": [
            {
              "make": "Volkswagen",
              "model": "Jetta III",
              "year_model": 1995,
              "price": 12947.52,
              "licensed": true,
              "date_added": "2018-09-18"
            }
          ]
        }
    }   

    render(<DetailedCarView warehouse={warehouse} />)
    const testElement = screen.getByTestId('test-2')
    expect(testElement).toBeInTheDocument()
    expect(testElement).toHaveTextContent('This car can be found at: ' + warehouse.name + ', ' + warehouse.cars.location)
    expect(testElement).toContainHTML('<button')
})

test('favourites should render with one favourite vehicle', () => {
    const car = {
              "make": "Chevrolet",
              "model": "Corvette",
              "year_model": 2004,
              "price": 20019.64,
              "licensed": false,
              "date_added": "2018-01-27"
            }

    render(<Favourite car={car} />)
    const testElement = screen.getByTestId('test-3')
    expect(testElement).toBeInTheDocument()
    // expect(testElement).toHaveTextContent('aqsdfas: ' + car.price)
    expect(testElement).toHaveTextContent(car.year_model + ' ' + car.make + ' ' + car.model)
})