function lockedProfile() {
  const buttons = Array.from(document.getElementsByTagName("button"));

  buttons.forEach((btn) => {
    btn.addEventListener("click", toggleInformation);
  });
  function toggleInformation(e) {
    const btn = e.currentTarget;
    const currentCard = btn.parentElement;
    const cardChildren = Array.from(currentCard.children);
    const moreInformation = cardChildren[9];
    const radioUnlockChecked = cardChildren[4];
    if (radioUnlockChecked.checked) {
      if (btn.textContent === "Show more") {
        moreInformation.style.display = "block";
        btn.textContent = "Hide it";
      } else if (btn.textContent === "Hide it") {
        moreInformation.style.display = "none";
        btn.textContent = "Show more";
      }
    }
  }

  console.log(buttons);
}
