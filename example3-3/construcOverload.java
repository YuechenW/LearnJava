/*ע�����ظ�ʽ����д���������ü��� */
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