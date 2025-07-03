document.querySelectorAll('.show_button').forEach(button => {
  button.addEventListener('click', () => {
    const parentDiv = button.closest('div').parentElement;

    const hiddenElements = parentDiv.querySelectorAll('.hidden_text, .hidden_list, .hidden_table');

    let anyShown = false;

    hiddenElements.forEach(element => {
      if (element.style.display === 'none' || element.style.display === '') {
        element.style.display = 'block';
        anyShown = true;
      } else {
        element.style.display = 'none';
      }
    });

    if (anyShown) {
      setTimeout(() => {
        const rect = parentDiv.getBoundingClientRect();
        const scrollOffset = window.scrollY + rect.bottom - window.innerHeight + 200;
        window.scrollTo({ top: scrollOffset, behavior: 'smooth' });
      }, 100);
    }
  });
});
