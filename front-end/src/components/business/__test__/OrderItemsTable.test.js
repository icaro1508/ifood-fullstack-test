import React from 'react'

import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import OrderItemsTable from 'components/business/OrderItemsTable'

describe('OrderItemsTable tests', () => {

    test('Should Render Items', () => {
        const items = [
            {
                description: 'Item 1',
                quantity: 1,
                price: 10.0
            },
            {
                description: 'Item 2',
                quantity: 2,
                price: 2.0
            }
        ]


        render(
            <OrderItemsTable items={items} />
        )

        expect(screen.getAllByText(/Item/g).length).toBe(2)
    })

    test('Should calculate total', () => {
        const items = [
            {
                description: 'Item 1',
                quantity: 5,
                price: 10.0
            }
        ]


        render(
            <OrderItemsTable items={items} />
        )

        expect(screen.queryByText("R$50.00")).toBeTruthy()
    })
})