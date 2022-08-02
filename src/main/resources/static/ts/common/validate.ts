const isNull = (obj :any) :boolean => {
    return obj == null || obj == "";
}

const negativeNumber = (val :number) :boolean => {
    return val < 0 || isNull(val);
}