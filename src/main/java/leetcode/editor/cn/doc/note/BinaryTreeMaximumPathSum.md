// 根、 左根、 右根 可以继续向上链接， 取最大值返回
int retVal = max(rootVal, leftVal + rootVal, rightVal + rootVal);
// 左根右   无法继续向上链接，判断当前最大值
maxVal = max(maxVal, leftVal + rootVal + rightVal, retVal);