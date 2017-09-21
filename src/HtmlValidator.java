import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml2(Queue<HtmlTag> tags) {
        Stack<HtmlTag> openTags = new Stack<>();
        LinkedList<HtmlTag> closeTags = new LinkedList<>();
        Stack<HtmlTag> resultTags = new Stack<>();
        HtmlTag openTag, closeTag;
        HtmlTag currentTag;

        System.out.println("queues of tags");
        System.out.println(tags);

        while (!tags.isEmpty()) {
            currentTag = tags.poll();
            if (!currentTag.isSelfClosing()) {
                if (currentTag.isOpenTag()) {
                    openTags.push(currentTag);
                } else {
                    closeTags.add(currentTag);
                }
            }
        }
        System.out.println("Open tags");
        System.out.println(openTags);
        System.out.println("Close tags");
        System.out.println(closeTags);
        if (openTags.isEmpty() || closeTags.isEmpty() || closeTags.size() > openTags.size()) {
            System.out.println("return null");
            return null;
        }
        while (!closeTags.isEmpty() || !openTags.isEmpty()) {
            System.out.println("while2");
            openTag = openTags.peek();
//            openTag = openTags.pop();
            System.out.println("Open Tag" + openTag);
            closeTag = closeTags.getFirst();
            System.out.println("Close Tag" + closeTag);
            System.out.println(openTag.element + "==" + closeTag.element);

            if (openTag.element.equals(closeTag.element)) {
                openTags.pop();
                closeTags.removeFirst();
                //break;
            } else {
//            openTags.pop();
                break;
            }

        }
        System.out.println(closeTags);
        System.out.println("Open STACK ");
        System.out.println(openTags);
        return openTags; // this line is here only so this code will compile if you don't modify it
    }


    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> pendingTags = new Stack<>();
        HtmlTag openTag;
        HtmlTag currentTag;
        System.out.println("queues of tags");
        System.out.println(tags);
        while (!tags.isEmpty()) {
            currentTag = tags.poll();
            if (currentTag.isSelfClosing()) {
                continue;
            }

            if (currentTag.isOpenTag()) {
                pendingTags.push(currentTag);
            } else if(pendingTags.isEmpty()) {
                System.out.println("return null");
                return null;
            }
            else{
                openTag =  pendingTags.peek();
                System.out.println(currentTag.element + "==" + openTag.element);
                if (currentTag.element.equals(openTag.element)){
                    pendingTags.pop();
                }
                else {
                    break;
                }
            }
            System.out.println("pendingTags=");
            System.out.println(pendingTags);
        }
        System.out.println("result pendingTags");
        System.out.println(pendingTags);
        return pendingTags; // this line is here only so this code will compile if you don't modify it
    }
}

