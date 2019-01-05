import java.util.Stack;

public class ReverseInterger_7 {
	public static void main(String[] args) {
		reverse(762);
	}

	public static int reverse(int x) {
		long result = 0;
		String str = String.valueOf(x);
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++)
			stack.push(str.charAt(i));
		str = "";
		while (stack.size() > 1)
			str += stack.pop();
		if (stack.peek() != '-') {
			str += stack.pop();
			result = Long.parseLong(str);
		} else {
			result = -Long.parseLong(str);
		}
		System.out.println("result = " + result);
		return x;
	}
}
