export default (locale = 'pt-br') => {

    const formatter = new Intl.NumberFormat(locale, {
        style: 'currency',
        currency: 'BRL'
    })

    return value => {
        return formatter.format(value)
    }
}