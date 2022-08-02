const checkProdName = (obj :string) :boolean => {
    if(isNull(obj)) {
        alert("상품명은 필수 입력값입니다.");
        return false;
    }
    return true;
}
const checkProdPrice = (val :number) :boolean => {
    if(negativeNumber(val)) {
        alert("0보다 큰 숫자를 입력해주세요.");
        return false;
    }
    return true;
}
