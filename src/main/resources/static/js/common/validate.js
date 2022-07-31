function isNull(obj) {
    return obj == null || obj == "";
}

function negativeNumber(val) {
    return val < 0 || isNull(val);
}