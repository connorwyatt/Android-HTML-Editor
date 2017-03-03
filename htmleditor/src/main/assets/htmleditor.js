var editorElement = document.querySelector('[editor]');

editorElement.addEventListener('input', function(event) {
  var currentValue = event.target.innerHTML;

  androidInterface.onContentChanged(currentValue);
});
