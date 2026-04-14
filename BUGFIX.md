# Fix: Login 502 error

Resolved the 502 error that occurred during login.
# Fix: Login 503 error

Resolved the 503 error during login.

# Fix: add returns a + b

Observed behavior:
- function `add` returns `d` instead of `a + b`

Expected behavior:
- function `add` should return `a + b`

Acceptance note:
- demo fix entry for bounty `e3a59cf1-fd37-4a58-98b8-c66cf2cf31ed`
- required check: `unit:test-simple-fix=pass`
