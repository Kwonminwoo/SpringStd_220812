package hello.itemservice.web.basic;


import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;


    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return  "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

//    @PostMapping("/add")  // 같은 url이 와도 다른 메소드(Get, Post)로 받아 다르게 처리
    public String addItemV1(@RequestParam String itemName, @RequestParam int price, @RequestParam Integer quantity, Model model){
        Item item = new Item(itemName, price, quantity);

        itemRepository.save(item);
        model.addAttribute("item", item);
        return "basic/item";
    }
   //dd


    // ModelAttribute 이용
    // @PostMapping("/add")  // 같은 url이 와도 다른 메소드(Get, Post)로 받아 다르게 처리
    public String addItemV2(@ModelAttribute("item") Item item){ // ModelAttirbute의 이름이 Model에 담기는 이름과 같음
        itemRepository.save(item);
//        model.addAttribute("item", item);
        return "basic/item";
    }

    // ModelAttribute 이용 2
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){
        // ModelAttribute의 이름을 생략하면 클래스명의 앞 글자를 소문자로 바꾼 것을 name으로 사용 Item -> item
        itemRepository.save(item);
//        model.addAttribute("item", item);
        return "basic/item";
    }


    // 리다이렉트 이용으로 중복 저장 오류 방지
    @PostMapping("/add")
    public String addItemV4(@ModelAttribute Item item){
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId(); // 이렇게 + 연산을 하면 오류 발생 가능성 높음
    }

    // 리다이렉트시 저장되었음을 확인 시켜주기 위함
    @PostMapping("/add")
    public String addItemV5(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true); // status가 true이면 저장이 되었다고 임의 판단단
       return "redirect:/basic/items/{itemId}"; // redirectAttribute에 담긴 것으로 지정가능
        // 이용되지 않은 것은 쿼리 파라미터로 넘어간다. ?status=true
    }


    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    // 테스트용으로 만듬듬
   @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 12000, 20));
    }
}
