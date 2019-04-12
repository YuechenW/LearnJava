/*注意重载格式，先写最长，其余调用即可 */
public  class construcOverload {
    int x, y;
    construcOverload() {
        this(0.0);
    }
    construcOverload(int x) {
        this(x,0);
    }
    construcOverload(int x, int y) {
        this.x=x;
        this.y=y;
    }

}