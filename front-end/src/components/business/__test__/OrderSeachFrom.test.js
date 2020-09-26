import React from 'react'

import { render, fireEvent, screen } from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import OrdersSearchForm from 'components/business/OrdersSearchForm'

describe('OrdersSearchForm tests', () => {
    function getTodayDateString() {
        var d = new Date(),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;

        return [year, month, day].join('-');
    }
    test('Initial render dates should be Today', () => {
        const mockOnSubmit = jest.fn(x => x)

        render(<OrdersSearchForm onSubmit={mockOnSubmit} />)

        fireEvent.click(screen.getByText('Search'), { bubbles: true })

        const passedArgs = mockOnSubmit.mock.calls[0][0]
        const expected = getTodayDateString()
        expect(passedArgs.after).toBe(expected)
        expect(passedArgs.before).toBe(expected)
    })


    test('Should call onSubmit when Search is clicked', () => {
        const mockOnSubmit = jest.fn(x => x)

        render(<OrdersSearchForm onSubmit={mockOnSubmit} />,)

        fireEvent.click(screen.getByText('Search'), { bubbles: true })

        expect(mockOnSubmit).toBeCalled()
    })

    test('onSubmit should recieve form parameters', () => {
        const mockOnSubmit = jest.fn(x => x)

        render(<OrdersSearchForm onSubmit={mockOnSubmit} />)

        const nameInput = screen.getByLabelText('Client Name')
        const phoneInput = screen.getByLabelText('Phone')
        const emailInput = screen.getByLabelText('E-mail')

        fireEvent.change(nameInput, { target: { value: 'john' } })
        fireEvent.change(phoneInput, { target: { value: '1234' } })
        fireEvent.change(emailInput, { target: { value: 'mail@mail.com' } })

        fireEvent.click(screen.getByText('Search'), { bubbles: true })

        const passedArgs = mockOnSubmit.mock.calls[0][0]
        expect(passedArgs.name).toBe('john')
        expect(passedArgs.phone).toBe('1234')
        expect(passedArgs.email).toBe('mail@mail.com')
    })
})