export const getPagination = (page, size) =>{
    const limit = size ? +size : 3
    const offset = page * limit ? page : 0
    return { limit, offset }
}