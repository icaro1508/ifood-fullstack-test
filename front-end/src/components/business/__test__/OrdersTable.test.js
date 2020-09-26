import React from 'react'

import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import OrdersTable from 'components/business/OrdersTable'
import { AppContext } from 'context/AppContext'

describe('OrdersTable tests', () => {

    test('Should Render Orders', () => {
        const orders = {
            orders: [
                {
                    id: '1',
                    client: {
                        name: 'John Doe',
                        phone: '12345678',
                        email: 'john@doe.com',
                    }
                },
                {
                    id: '2',
                    client: {
                        name: 'John Doe',
                        phone: '12345678',
                        email: 'john@doe.com',
                    }
                }
            ]
        }


        render(
            <AppContext.Provider value={{ state: orders }}>
                <OrdersTable />
            </AppContext.Provider>
        )

        expect(screen.getAllByText('John Doe').length).toBe(2)
    })
})