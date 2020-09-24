import React, { useCallback, useState } from 'react'
import PropTypes from 'prop-types'
import styled from 'styled-components'

import Form from 'react-bootstrap/Form'
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Datetime from 'react-datetime'
import { Button } from 'react-bootstrap'

import moment from 'moment'

const FormContainer = styled.div`
border-color: #ececec;`

const MemoizedDatetime = React.memo(Datetime)
const DATE_FORMAT_STRING = "YYYY-MM-DD"

const OrdersSearchForm = ({ onSubmit }) => {
    const [after, setAfter] = useState(moment().format(DATE_FORMAT_STRING))
    const [before, setBefore] = useState(moment().format(DATE_FORMAT_STRING))
    const [name, setName] = useState('')
    const [phone, setPhone] = useState('')
    const [email, setEmail] = useState('')


    const updateStartDateCallBack = useCallback(date => setAfter(date.format(DATE_FORMAT_STRING)), [])
    const updateEndDateCallBack = useCallback(date => setBefore(date.format(DATE_FORMAT_STRING)), [])
    const updateClientNameCallBack = useCallback(e => setName(e.target.value), [])
    const updatePhoneCallBack = useCallback(e => setPhone(e.target.value), [])
    const updateEmailCallBack = useCallback(e => setEmail(e.target.value), [])

    const callOnSubmit = useCallback(() => {
        onSubmit({ after, before, name, phone, email })
    }, [onSubmit, after, before, name, phone, email])

    return (
        <FormContainer className="border p-4">
            <Form>
                <Container>
                    <Row>
                        <Col className="col-12 col-sm-6 col-md-3 col-lg col-xl">
                            <Form.Group>
                                <Form.Label>Start Date</Form.Label>
                                <MemoizedDatetime
                                    initialValue={after}
                                    dateFormat="YYYY-MM-DD"
                                    timeFormat={false}
                                    onChange={updateStartDateCallBack} />
                            </Form.Group>
                        </Col>
                        <Col className="col-12 col-sm-6 col-md-3 col-lg col-xl">
                            <Form.Group>
                                <Form.Label>End Date</Form.Label>
                                <MemoizedDatetime
                                    initialValue={before}
                                    dateFormat="YYYY-MM-DD"
                                    timeFormat={false}
                                    onChange={updateEndDateCallBack} />
                            </Form.Group>
                        </Col>
                        <Col className="col-12 col-sm-12 col-md-6 col-lg col-xl">
                            <Form.Group>
                                <Form.Label>Client Name</Form.Label>
                                <Form.Control type="text" value={name} onChange={updateClientNameCallBack} />
                            </Form.Group>
                        </Col>
                        <Col className="col-12 col-sm-6 col-md-5 col-lg col-xl">
                            <Form.Group>
                                <Form.Label>Phone</Form.Label>
                                <Form.Control type="text" value={phone} onChange={updatePhoneCallBack} />
                            </Form.Group>
                        </Col>
                        <Col className="col-12 col-sm-6 col-md-7 col-lg col-xl">
                            <Form.Group>
                                <Form.Label>E-mail</Form.Label>
                                <Form.Control type="text" value={email} onChange={updateEmailCallBack} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row className="justify-content-end">
                        <Col className="col-4 col-sm-2">
                            <Button onClick={callOnSubmit}>Search</Button>
                        </Col>
                    </Row>
                </Container>
            </Form>
        </FormContainer>
    )
}

OrdersSearchForm.propTypes = {
    onSubmit: PropTypes.func.isRequired
}
OrdersSearchForm.defaultPropss = {
    onSubmit: () => { }
}

export default OrdersSearchForm