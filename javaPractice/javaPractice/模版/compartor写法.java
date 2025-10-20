//降序，注意这些写法都是对于封装数据类型的，基础数据类型不能与comparator并用(但是基础数据的指针又可以了（二维数组可以）。Comparator参数仅支持引用类型)
Arrays.sort(intervals, n new Comparator<Integer>() {
        		//重写compare方法，最好加注解，不加也没事
            public int compare(Integer a, Integer b) {
              	//返回值>0交换
                return b-a;
            }
        });


//
Arrays.sort(arr, (a, b) -> {
    //返回值>0交换
    return b-a;
});

//

import java.util.Comparator;

Arrays.sort(arr, new compa());
class compa implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
    	// A.compareTo(B) A>B 返回1，A=B 返回0，A<B 返回-1
      	// compareTo()返回值>0就交换
      	// 如果02 > o1 就交换 =>降序
        return o2.compareTo(o1);
    }
}

//Comparator是一个函数式接口（Functional Interface），因此，可以使用lambda表达式进一步简化
int[][] rooms
Arrays.sort(rooms, (a, b) -> (b[1] - a[1]));


//类内写
class Event implements Comparable<Event> {
    int type, size, id, origin;

    public Event(int type, int size, int id, int origin) {
        this.type = type;
        this.size = size;
        this.id = id;
        this.origin = origin;
    }

    @Override
    public int compareTo(Event that) {
        // 自定义比较函数，按照事件的 size 降序排序
        // 如果 size 相同，优先考虑房间
        if (this.size != that.size) {
            return Integer.compare(that.size, this.size);
        } else {
            return Integer.compare(this.type, that.type);
        }
    }
}

Collections.sort(events);





//int数组转integer数组
Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);






//大根堆三种写法
static class MyComp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());
.....

//
PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
});

//
PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 -o1);

